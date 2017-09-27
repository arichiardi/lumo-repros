(ns speed-of-light.core
  "The entry point of this program"
  (:require [speed-of-light.util]
            [util :as node-util]))

(enable-console-print!)

(defn -main
  [& args]
  (println "Start!")
  (println (util/cjs-merge #js {:hello "world"} #js {:world "hello"}))
  (process.exit 1))

(set! *main-cli-fn* `-main)
