(ns speed-of-light.core
  "The entry point of this program"
  (:require [cljs.nodejs :as node]))

(enable-console-print!)

(def AWS (js/require "aws-sdk"))

(defn ^:export -main
  [& args]
  (println "Hello AWS world!"))

(set! *main-cli-fn* -main)
