(ns speed-of-light.core
  "The entry point of this program"
  (:require [cljs.core.async :as async :refer [<! >!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(enable-console-print!)

(def c (async/chan 1))

(go-loop [val (<! c)]
  (println "Received:" val))

(defn ^:export -main
  [& args]
  (async/put! c "Hello World!"))

(set! *main-cli-fn* -main)
