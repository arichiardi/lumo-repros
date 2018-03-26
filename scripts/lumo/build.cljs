(require '[lumo.build.api :as api]
         '[lumo.classpath :as cp]
         '[cljs.pprint :refer [pprint]])

(def compiler-opts
  {:main 'speed-of-light.core
   :output-to "out/speed_of_light.js"
   :output-dir "out"
   :optimizations :none
   :verbose true
   :target :nodejs
   :install-deps false
   :npm-deps {:lodash.camelcase "4.3.0"
              :lodash.kebabcase "4.1.1"}})

(pprint compiler-opts)

(api/build "src" compiler-opts)
