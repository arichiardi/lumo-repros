(ns speed-of-light.core
  "The entry point of this program"
  (:require can-promise))

(enable-console-print!)

(defn -main
  [& args]
  (println "Hello - can I promise?" (can-promise))
  (process.exit 0))

(set! *main-cli-fn* `-main)

(-main)
