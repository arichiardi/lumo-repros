(ns speed-of-light.core
  "The entry point of this program"
  (:require [cljs.nodejs :as node]))

(def AWS (js/require "aws-sdk"))

(defn ^:export -main
  [& args]
  )

(enable-console-print!)
(set! *main-cli-fn* -main)
