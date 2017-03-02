(require '[cljs.build.api :as b])

(println "Building ...")

(let [start (System/nanoTime)]
  (b/build "src"
           {:main 'lumo-repros.core
            :output-to "out/lumo_repros.js"
            :output-dir "out"
            :optimizations :none
            :verbose true
            :npm-deps {"aws-sdk" "2.22.0"
                       "source-map-support" "0.4.0"}
            :target :nodejs})
  (println "... done. Elapsed" (/ (- (System/nanoTime) start) 1e9) "seconds"))
