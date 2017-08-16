# speed-of-light

## Usage

For launching a (lumo) repl, use `boot dev`<img width="24px" height="24px" src="https://github.com/boot-clj/boot-clj.github.io/blob/master/assets/images/logos/boot-logo-3.png" alt="Boot Logo"/>.

The project also uses [mach](https://github.com/juxt/mach) for dumping the classpath when necessary so in theory the repl could be launched with:

    mach cp && lumo -c `cat cp`

For compiling and reproducing compilation bugs:

    lumo -c src scripts/lumo_build.cljs

The above produces the following at the moment:

```console
failed compiling file:out/cljs/core.cljs
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1934:200)
	 (evalmachine.<anonymous>:609:25)
	 Function.lumo.compiler.compile_file.cljs$core$IFn$_invoke$arity$4 (evalmachine.<anonymous>:616:4)
	 (Object.lumo$closure$compile_file)
	 (evalmachine.<anonymous>:1625:21)
	 (Object.lumo$closure$_compile)
	 (Object.lumo$closure$compile_from_jar)
	 (evalmachine.<anonymous>:1660:21)
	 (Object.lumo$closure$_compile)

should never happen!
	 (new)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$3 (NO_SOURCE_FILE <embedded>:1934:200)
	 Function.cljs.core.ex_info.cljs$core$IFn$_invoke$arity$2 (NO_SOURCE_FILE <embedded>:1934:88)
	 (Object.lumo$io$slurp)
	 (Object.lumo$compiler$emit_cached_core)
	 (evalmachine.<anonymous>:482:28)
	 Function.lumo.compiler.with_core_cljs.cljs$core$IFn$_invoke$arity$2 (evalmachine.<anonymous>:231:85)
	 Function.lumo.compiler.compile_file_STAR_.cljs$core$IFn$_invoke$arity$4 (evalmachine.<anonymous>:461:41)
	 (evalmachine.<anonymous>:586:41)
	 Function.lumo.compiler.compile_file.cljs$core$IFn$_invoke$arity$4 (evalmachine.<anonymous>:616:4)
```

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
