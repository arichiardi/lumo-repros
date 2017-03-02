(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'lumo-repros.core
   :output-to "out/lumo_repros.js"
   :output-dir "out"})
