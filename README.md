# Memory Leak Test

![](https://img.shields.io/static/v1?style=flat-square&logo=android&label=API&message=22%2B&color=78c257) 
![https://kotlinlang.org/](https://img.shields.io/static/v1?style=flat-square&label=Kotlin&message=1.3.50&color=007ec6) 

This is a sample code used to generate a memory leak and detect it with _Leak Canary_, it combines the sample app from the oficial library and an instrumented test created by [Marcos Holgado](@Orbycius) you can generate Leaks two ways:

- Run the app and change the orientation 5 times (default threshold of retained instances), this choice will run the _Leak Canary_ app
- Run the Instrumentation test `LeakInstrumentedTest`, this choice will show the Leak information in the Logcat
 
## Reference links:
 
[Leak Canary page](https://square.github.io/leakcanary/)

[Marcos Holgado - Detect memory leaks in your instrumentation tests using LeakCanary](https://proandroiddev.com/detecting-memory-leaks-in-your-instrumentation-tests-using-leakcanary-1268e911d5ce)
