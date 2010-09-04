
(ns alien-whisper.test.js
  (:require js-test)
  (:use clojure.contrib.singleton)
  (:use clojure.test))

(def runner
     (per-thread-singleton
      #(js-test/init "test/js/" ["test.js"]
                     "src/js/" ["jsbn.js"])))

(deftest js-assert
  (js-test/run (runner) "test_assert"))

(comment ;; TODO
  def-js-tests {"test/js/" ["test.js"]
                "src/js/" ["jsbn.js"]}
  :test-assert
  :test-whatever)
