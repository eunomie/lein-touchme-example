(ns lein-touchme-example.template
  (:require [net.cgrand.enlive-html :as html])
  (:use [net.cgrand.moustache :only [app]]
        [lein-touchme-example.utils :only [run-server render-to-response]]))

(html/deftemplate index "../resources/template.html" [ctxt])

(def routes
  (app
   [""]       (fn [req] (render-to-response
                         (index {})))
   [&]        {:status 404
               :body "Page Not Found"}))
 
(defonce ^:dynamic *server* (run-server routes))
