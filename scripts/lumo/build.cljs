(require '[lumo.build.api :as api]
         '[lumo.classpath :as cp]
         '[cljs.pprint :refer [pprint]]
         '[lumo.io :as io]
         '[cljs.reader :as edn])


(def compiler-opts (-> "cljsc_opts.edn" io/slurp edn/read-string))

(set! cljs.core/*print-newline* true)

(pprint compiler-opts)

(api/build "src" compiler-opts)
