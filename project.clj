(defproject lein-touchme-example "0.1.0"
  :description "Example of leiningen 'touchme' plugin."
  :url "https://github.com/sogilis/lein-touchme-example"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [enlive "1.1.2"]
                 [ring "1.2.0"]
                 [net.cgrand/moustache "1.1.0"]]
  :plugins [[touchme "0.1.0"]]

  ; touch only one file
  :touchme-config {:path-to-observe "resources"
                   :extension-to-observe ".html"
                   :file-to-touch "lein_touchme_example/template.clj"}

  ; touch similar file names into a specific path
  ;:touchme-config {:path-to-observe "resources"
  ;                 :extension-to-observe ".html"
  ;                 :path-of-files-to-touch "lein_touchme_example"}
  )
