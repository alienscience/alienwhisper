
(ns alien-whisper.test.js
  (:require js-test)
  (:use clojure.contrib.singleton)
  (:use clojure.test))

;;------- Test setup -----------------------------------------------------------
(def *js-runner* nil)

(defn create-runner []
  (js-test/init
   "test/js/" ["test.js"]
   "war/js/"  ["Iuppiter.js", "jsbn.js", "rsa.js",
               "rsa2.js", "rsa_base64.js", "sjcl.js",
               "alienwhisper.js"]))

(defn with-js-runner [run-tests-fn]
  (binding [*js-runner* (create-runner)]
    (run-tests-fn)))

(use-fixtures :once with-js-runner)

;;------- The tests ------------------------------------------------------------

(deftest js-assert
  (js-test/run *js-runner* "test_assert"))

(deftest encrypt
  (js-test/run *js-runner* "test_encrypt"))

(comment ;; TODO
  def-js-tests {"test/js/" ["test.js"]
                "src/js/" ["jsbn.js"]}
  :test-assert
  :test-whatever)
