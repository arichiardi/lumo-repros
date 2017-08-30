(ns speed-of-light.core
  "The entry point of this program"
  (:require [speed-of-light.util :as util]))

(enable-console-print!)

(defn ^:export -main
  [& args]
  (println "Hello world!"))

(set! *main-cli-fn* -main)
