package cn.shilx.starter;

import io.reactivex.disposables.Disposable;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;

/**
 * @author shilixiang
 */
public class VertxStarter {
    public static final int PROC_NUM = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        /* 获得vertx实例 */
        Vertx vertx = Vertx.vertx(new VertxOptions()
            .setEventLoopPoolSize(PROC_NUM)
            .setPreferNativeTransport(true));

        DeploymentOptions multiInstance = new DeploymentOptions().setInstances(PROC_NUM);

        vertx.rxDeployVerticle(MainVerticle.class.getName(), multiInstance).subscribe();

    }

}
