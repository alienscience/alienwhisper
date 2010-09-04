
(ns leiningen.gae-war
  (:require [clojure.contrib.duck-streams :as duck])
  (:use [clojure.contrib.java-utils :only [file]]))

(defn find-files 
  "Returns all files in and below the given directory. If 
passed the path of a file returns a sequence containing a single 
file object."
  [path] 
  (file-seq (file path)))

(defn re-filter 
  "Uses the given regular expression to filter a sequence"
  [re s]
  (filter #(if (re-find re (str %)) %) s))

(defn re-remove 
  "Uses the given regular expression to filter a sequence.
   Returns strings that do not match the given re."
  [re s]
  (filter #(if-not (re-find re (str %)) %) s))

(defn find-jars
  "Returns the path of all the jars in the given path"
  [dir]
  (re-filter #".jar$" (find-files dir)))

(defn dependency-jars
  "Returns the jar files that are dependencies of a project."
  [project]
  (let [dev-pattern #"[\\/]dev[\\/][^\\/]+\.jar"]
    (re-remove dev-pattern (find-jars (:library-path project)))))

(defn gae-war
  "Prepare the war directory for the google app engine"
  [project & args]
  (doseq [src (dependency-jars project)
          :let [fname (.getName src)]]
    (duck/copy src (duck/file-str "war/WEB-INF/lib/" fname))))
