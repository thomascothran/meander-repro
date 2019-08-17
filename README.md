# Meander Spec Error Reproduction

To reproduce, run `clojure -A:dev`. Code is in the `user.clj` namespace, taken from the Meander README examples.

## Example stack trace

Exception in thread "main" Syntax error macroexpanding m/match at (user.clj:26:1).
Call to #'meander.match.delta/analyze-match-args did not conform to spec.
        at clojure.lang.Compiler.macroexpand1(Compiler.java:7010)
        at clojure.lang.Compiler.macroexpand(Compiler.java:7075)
        at clojure.lang.Compiler.eval(Compiler.java:7161)
        at clojure.lang.Compiler.load(Compiler.java:7636)
        at clojure.lang.RT.loadResourceScript(RT.java:381)
        at clojure.lang.RT.loadResourceScript(RT.java:368)
        at clojure.lang.RT.maybeLoadResourceScript(RT.java:364)
        at clojure.lang.RT.doInit(RT.java:486)
        at clojure.lang.RT.init(RT.java:467)
        at clojure.main.main(main.java:38)
Caused by: clojure.lang.ExceptionInfo: Call to #'meander.match.delta/analyze-match-args did not conform to spec. {:clojure.spec.alpha/problems [{:path [:match-args :clauses :rhs], :reason "Insufficient input", :pred :meander.match.delta/expr, :val (), :via [:meander.match.delta/expr], :in []}], :clojure.spec.alpha/spec #object[clojure.spec.alpha$regex_spec_impl$reify__2509 0x790ac3e0 "clojure.spec.alpha$regex_spec_impl$reify__2509@790ac3e0"], :clojure.spec.alpha/value ((42 (pred even?) :okay) nil), :clojure.spec.alpha/fn meander.match.delta/analyze-match-args, :clojure.spec.alpha/args ((42 (pred even?) :okay) nil), :clojure.spec.alpha/failure :instrument, :clojure.spec.test.alpha/caller {:file "delta.cljc", :line 2021, :var-scope meander.match.delta/match}}
        at clojure.spec.test.alpha$spec_checking_fn$conform_BANG___3024.invoke(alpha.clj:132)
        at clojure.spec.test.alpha$spec_checking_fn$fn__3026.doInvoke(alpha.clj:140)
        at clojure.lang.RestFn.invoke(RestFn.java:421)
        at meander.match.delta$match.invokeStatic(delta.cljc:2021)
        at meander.match.delta$match.doInvoke(delta.cljc:2017)
        at clojure.lang.RestFn.applyTo(RestFn.java:142)
        at clojure.lang.Var.applyTo(Var.java:705)
        at clojure.lang.Compiler.macroexpand1(Compiler.java:6993)
        ... 9 more
