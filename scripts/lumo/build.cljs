(require '[lumo.build.api :as api]
         '[lumo.classpath :as cp]
         '[cljs.pprint :refer [pprint]])

(def compiler-opts
  {:main 'speed-of-light.core
   :output-to "out/speed_of_light.js"
   :output-dir "out"
   :optimizations :advanced
   :source-map "out/speed_of_light.js.map"
   :target :nodejs
   :verbose true})

(pprint compiler-opts)

(api/build "src" compiler-opts)
