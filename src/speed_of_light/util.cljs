(ns speed-of-light.util
  (:require [goog.object :as gobj]))

(defn js-merge
  "Like clojure.core/merge, but for JS objects"
  [m1 m2]
  (doto m1 (gobj/extend m2)))
