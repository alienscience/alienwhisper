
(ns alien-whisper.routes
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes app-routes
  (GET  "/s/" []
        "<h1>Hello World from Alien Whisper</h1>")
  (route/not-found "Page not found"))


