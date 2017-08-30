# lumo-repros

For compiling and reproducing compilation bugs:

    lumo -c src scripts/lumo_build.cljs

If the `util` namespace contains:

```clojure
(ns speed-of-light.util
  (:require [clojure.pprint :as pprint]))
```

The `lumo -c src scripts/lumo_build.cljs` produces the following at the moment:

```console
failed compiling file:out/cljs/core.cljs
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1923:72)
	 (evalmachine.<anonymous>:609:25)
	 Function.lumo.compiler.compile_file.cljs$core$IFn$_invoke$arity$4 (evalmachine.<anonymous>:616:4)
	 (Object.lumo$closure$compile_file)
	 (evalmachine.<anonymous>:1625:21)
	 (Object.lumo$closure$_compile)
	 (Object.lumo$closure$compile_from_jar)
	 (evalmachine.<anonymous>:1660:21)
	 (Object.lumo$closure$_compile)

failed compiling file:/home/arichiardi/git/lumo-repros/src/speed_of_light/util.cljs
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1923:72)
	 (evalmachine.<anonymous>:609:25)
	 Function.lumo.compiler.compile_file.cljs$core$IFn$_invoke$arity$4 (evalmachine.<anonymous>:616:4)
	 (Object.lumo$closure$compile_file)
	 (evalmachine.<anonymous>:1625:21)
	 (Object.lumo$closure$_compile)
	 (evalmachine.<anonymous>:1651:21)
	 (Object.lumo$closure$_compile)
	 (evalmachine.<anonymous>:2248:21)

Could not analyze dep clojure.pprint
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1923:72)
	 Function.cljs.analyzer.error.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:2555:92)
	 Function.cljs.js.analyze_deps.cljs$core$IFn$_invoke$arity$6 (NO_SOURCE_FILE <embedded>:5581:48)
	 Function.cljs.js.ns_side_effects.cljs$core$IFn$_invoke$arity$6 (NO_SOURCE_FILE <embedded>:5621:233)
	 Function.cljs.js.ns_side_effects.cljs$core$IFn$_invoke$arity$5 (NO_SOURCE_FILE <embedded>:5602:106)
	 v (NO_SOURCE_FILE <embedded>:5688:538)
	 Object.cljs.js.compile_str_STAR_ (NO_SOURCE_FILE <embedded>:5692:57)
	 Function.cljs.js.compile_str.cljs$core$IFn$_invoke$arity$5 (NO_SOURCE_FILE <embedded>:5695:511)
	 (Object.lumo$compiler$emit_source)

No such namespace: clojure.pprint, could not locate clojure/pprint.cljs, clojure/pprint.cljc, or JavaScript source providing "clojure.pprint"
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1923:72)
	 Function.cljs.analyzer.error.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:2555:92)
	 Function.cljs.analyzer.error.cljs$core$IFn$_invoke$arity$2 (NO_SOURCE_FILE <embedded>:2554:92)
	 (NO_SOURCE_FILE <embedded>:5579:256)
	 Object.lumo.repl.load_other (NO_SOURCE_FILE <embedded>:6351:378)
	 lumo.repl.load (NO_SOURCE_FILE <embedded>:6355:96)
	 Function.cljs.js.analyze_deps.cljs$core$IFn$_invoke$arity$6 (NO_SOURCE_FILE <embedded>:5580:496)
	 Function.cljs.js.ns_side_effects.cljs$core$IFn$_invoke$arity$6 (NO_SOURCE_FILE <embedded>:5621:233)
	 Function.cljs.js.ns_side_effects.cljs$core$IFn$_invoke$arity$5 (NO_SOURCE_FILE <embedded>:5602:106)
```

Everything works with:

```clojure
(ns speed-of-light.util
  (:require [cljs.pprint :as pprint]))
```

Also this produces the problem (notice that `cljs.` is used, which was fine with `pprint`):

```clojure
(ns speed-of-light.util
  (:require [cljs.string :as string]))
```

## Other unrelated usage (please ignore)

For launching a (lumo) repl, use `boot dev`<img width="24px" height="24px" src="https://github.com/boot-clj/boot-clj.github.io/blob/master/assets/images/logos/boot-logo-3.png" alt="Boot Logo"/>.

The project also uses [mach](https://github.com/juxt/mach) for dumping the classpath when necessary so in theory the repl could be launched with:

    mach cp && lumo -c `cat cp`
    
## License

This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org>
