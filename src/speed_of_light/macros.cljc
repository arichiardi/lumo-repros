(ns speed-of-light.macros)

(defmacro safely-apply
  "Read JSON and return it.

  The error-res object is returned in case of errors, defaulting to
  nil."
  [body error-res]
  `(try
     ~body
     (catch :default ~'e
       (.error log ~'e)
       ~error-res)))

(defmacro read-json-safely
  [s]
  `(safely-apply (.parse js/JSON ~s) nil))
