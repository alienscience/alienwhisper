(defproject alien-whisper "0.0.1"
  :description "A messaging system"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [hiccup "0.3.0"]
                 [compojure "0.4.1"]
                 [ring/ring-servlet "0.2.5"]
                 [com.google.appengine/appengine-api-1.0-sdk "1.3.6"]
                 [com.google.appengine/appengine-api-labs "1.3.6"]]
  :dev-dependencies [[rhino/js "1.7R2"]
                     [swank-clojure "1.2.1"]
                     [ring/ring-jetty-adapter "0.2.5"]
                     [uk.org.alienscience/leiningen-war "0.0.7"]
                     [com.google.appengine/appengine-local-runtime "1.3.6"]
                     [com.google.appengine/appengine-api-stubs "1.3.6"]]
  :aot [alien-whisper.servlet]
  :compile-path "war/WEB-INF/classes")

