
(ns alien-whisper.servlet
  (:use ring.util.servlet)
  (:require [alien-whisper.routes :as routes])
  (:gen-class :extends javax.servlet.http.HttpServlet))

(defservice routes/app-routes)


