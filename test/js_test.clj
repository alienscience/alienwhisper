

(ns js-test
  (:import [org.mozilla.javascript Context]))

(defn- evaluate
  "Evaluate the given javascript file in the given dir"
  [context scope dir file]
  (let [reader (java.io.FileReader. (str dir file))]
    (println "Adding: " dir file)
    (.evaluateReader context scope reader file 1 nil)))

(defn init
  "Initialise the javascript testing environment."
  [test-dir test-includes main-dir main-includes]
  (let [context (Context/enter)
        scope (.initStandardObjects context)]
    (doseq [file main-includes]
      (evaluate context scope main-dir file))
    (doseq [file test-includes]
      (evaluate context scope test-dir file))
    ;; Return a function to run javascript strings
    (fn [script name]
      (.evaluateString context scope script name 1 nil))))


(defn run
  "Runs the javascript function with the given name"
  [runner fname]
  (let [script (str fname "();")]
    (runner script fname)))

