

(ns js-test
  (:import [org.mozilla.javascript Context]))

(defn- evaluate
  "Evaluate the given javascript file in the given dir using the given
   javascript runner"
  [runner dir file]
  (let [script (slurp (str dir file))]
    (runner script file)))

(defn init
  "Initialise the javascript testing environment."
  [test-dir test-includes main-dir main-includes]
  (let [context (Context/enter)
        scope (.initStandardObjects context)
        runner (fn [script name]
                 (.evaluateString context scope script name 1 nil))]
    (evaluate runner test-dir "test.js")
    (map (partial evaluate runner test-dir) test-includes)
    (map (partial evaluate runner main-dir) main-includes)
    runner))


(defn run
  "Runs the javascript function with the given name"
  [runner fname]
  (let [script (str fname "();")]
    (runner script fname)))

