(ns speed-of-light.core
  "The entry point of this program"
  (:require [tabby]))

(enable-console-print!)

(defn ^:export -main
  [& args]
  (println (tabby/hello)))

(set! *main-cli-fn* -main)
