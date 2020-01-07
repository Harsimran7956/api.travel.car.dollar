package com.kamadhenu.api.travel.car.dollar;

import com.kamadhenu.api.travel.car.dollar.controller.DollarController;
import com.kamadhenu.api.travel.car.dollar.exception.ExceptionHandler;
import com.kamadhenu.api.travel.car.dollar.util.Config;
import com.kamadhenu.api.travel.car.dollar.util.Path;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.metrics.MicrometerPlugin;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     * Entry point to the application
     *
     * @param args
     */
    public static void main(String[] args) {

        //load config once
        Config appConfig = Config.config();
        // get properties
        Properties properties = appConfig.getProperties();
        Integer port = Integer.parseInt(properties.getProperty("port"));
        Boolean debug = Boolean.parseBoolean(properties.getProperty("debug"));
        Boolean allowCors = Boolean.parseBoolean(properties.getProperty("allowcors"));
        Boolean allowSsl = Boolean.parseBoolean(properties.getProperty("allowssl"));
        String savePath = properties.getProperty("savePath");
        Integer maxThreads = Integer.parseInt(properties.getProperty("maxthreads"));
        Integer minThreads = Integer.parseInt(properties.getProperty("minthreads"));
        Integer timeOutMillis = Integer.parseInt(properties.getProperty("timeoutmillis"));

        //Thread pool
        QueuedThreadPool queuedThreadPool = new QueuedThreadPool(maxThreads, minThreads, timeOutMillis);

        // setup metrics
        PrometheusMeterRegistry prometheusMeterRegistry =
                new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);

        // setup main server
        Javalin javalin = Javalin.create(
                javalinConfig -> {
                    // set configs
                    if (allowCors) {
                        javalinConfig.enableCorsForAllOrigins();
                    }
                    if (debug) {
                        javalinConfig.enableDevLogging();
                    }
                    if (!savePath.isEmpty()) {
                        javalinConfig.addStaticFiles(savePath, Location.EXTERNAL);
                    }
                    javalinConfig.enforceSsl = allowSsl;
                    javalinConfig.showJavalinBanner = false;

                    // set metrics collection
                    javalinConfig.registerPlugin(new MicrometerPlugin(prometheusMeterRegistry));

                    new Server(queuedThreadPool);
                }
        ).events(eventListener -> {
            eventListener.serverStarting(() -> {
                LOGGER.info("Starting application");
            });
            eventListener.serverStarted(() -> {
                LOGGER.info("Started application");
            });
            eventListener.serverStartFailed(() -> {
                LOGGER.error("Error starting application");
            });
            eventListener.serverStopping(() -> {
                LOGGER.info("Stopping application");
            });
            eventListener.serverStopped(() -> {
                LOGGER.info("Stopped application");
            });
        }).start(port);

        javalin.routes(() -> {
            post(Path.SEARCH, DollarController.search);
            post(Path.XSELLITEM, DollarController.xsellitem);
            post(Path.BOOK, DollarController.book);
            post(Path.CANCEL, DollarController.cancel);
            get(Path.PROMETHEUS, ctx -> ctx.result(prometheusMeterRegistry.scrape()));
        });

        ExceptionHandler.handler(javalin);
    }
}

