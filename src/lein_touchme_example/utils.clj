(ns lein-touchme-example.utils
  (:require [net.cgrand.enlive-html :as html]
            [clojure.java.io :as io])
  (:use [ring.adapter.jetty :only [run-jetty]]
        [ring.util.response :only [response file-response]]
        [ring.middleware.reload :only [wrap-reload]]
        [ring.middleware.file :only [wrap-file]]
        [ring.middleware.stacktrace :only [wrap-stacktrace]]))

(def ^:dynamic *webdir* (str (.getCanonicalFile (io/file ".")) "/src/lein_touchme_example/"))

(defn render [t]
  (apply str t))

(def render-to-response
     (comp response render))

(defn serve-file [filename]
  (file-response
   {:root *webdir*
    :index-files? true
    :html-files? true}))

(defn run-server* [app & {:keys [port] :or {port 8080}}]
  (let [nses (if-let [m (meta app)]
               [(-> (:ns (meta app)) str symbol)]
               [])]
    (println "run-server*" nses)
    (run-jetty
     (-> app
         (wrap-file *webdir*)
         (wrap-reload nses)
         (wrap-stacktrace))
     {:port port :join? false})))

(defmacro run-server [app]
  `(run-server* (var ~app)))
