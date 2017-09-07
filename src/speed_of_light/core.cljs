(ns speed-of-light.core
  "The entry point of this program"
  (:require [cljs.core.async :as async :refer [<! >!]]
            [cljs.core.async.macros :refer-macros [go]]))

(enable-console-print!)

(def c (async/chan 1))

(go-loop [val (<! c)]
  (println "Received:" val))

(defn ^:export -main
  [& args]
  (async/put! c "Hello World!"))

(set! *main-cli-fn* -main)
