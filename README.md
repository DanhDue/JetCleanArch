Jet CleanArch - A modern sample base code.
=============================================

This project uses many of the popular libraries, plugins, and tools of the Android ecosystem.
It is based on [Android Jetpack][0], [Kotlin][1], [Clean Architecture][2] & [Dependency Injection][3] using [Hilt][4].

Introduction
------------

This project is a sample base code that implements the Clean Architecture and uses Android Jetpack. It presents modern approach to [Android](https://www.android.com/) application development using [Kotlin](https://kotlinlang.org/) and latest tech-stacks.

The goal of the project is to demonstrate best practices, provide a set of guidelines, and present modern Android
application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it
has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and
long application lifecycle management.

Architecture
------------

A well planned architecture is extremely important for an app to scale and all architectures have one common goal- to manage complexity of your app. This isn't something to be worried about in smaller apps however it may prove very useful when working on apps with longer development lifecycle and a bigger team.

Clean architecture was proposed by [Robert C. Martin](https://en.wikipedia.org/wiki/Robert_C._Martin) in 2012 in the [Clean Code Blog](http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html) and it follow the SOLID principle.

<p align="center"><img src="screenshots/clean_arch.jpeg" alt="Clean Architecture"></p>

The circles represent different layers of your app. Note that:

- The center circle is the most abstract, and the outer circle is the most concrete. This is called the [Abstraction Principle](https://en.wikipedia.org/wiki/Abstraction_principle_(computer_programming)). The Abstraction Principle specifies that inner circles should contain business logic, and outer circles should contain implementation details.

- Another principle of Clean Architecture is the [Dependency Inversion](https://en.wikipedia.org/wiki/Dependency_inversion_principle). This rule specifies that each circle can depend only on the nearest inward circle ie. low-level modules do not depend on high-level modules but the other way around.

<p align="center"><img src="screenshots/architecture.png" alt="Clean Architecture Diagram"></p>

Why Clean Architecture?
------------------------

- ```Loose coupling between the code``` - The code can easily be modified without affecting any or a large part of the app's codebase thus easier to scale the application later on.
- Easier to ```test``` code.
- ```Separation of Concern``` - Different modules have specific responsibilities making it easier for modification and maintenance.

S.O.L.I.D Principles
------------------------

- [__Single Responsibility__](https://en.wikipedia.org/wiki/Single-responsibility_principle): Each software component should have only one reason to change – one responsibility.

- [__Open-Closed__](https://en.wikipedia.org/wiki/Open%E2%80%93closed_principle#:~:text=In%20object%2Doriented%20programming%2C%20the,without%20modifying%20its%20source%20code.): You should be able to extend the behavior of a component, without breaking its usage, or modifying its extensions.

- [__Liskov Substitution__](https://en.wikipedia.org/wiki/Liskov_substitution_principle): If you have a class of one type, and any subclasses of that class, you should be able to represent the base class usage with the subclass, without breaking the app.

- [__Interface Segregation__](https://en.wikipedia.org/wiki/Interface_segregation_principle): It’s better to have many smaller interfaces than a large one, to prevent the class from implementing the methods that it doesn’t need.

- [__Dependency Inversion__](https://en.wikipedia.org/wiki/Dependency_inversion_principle): Components should depend on abstractions rather than concrete implementations. Also higher level modules shouldn’t depend on lower level modules.

Technical Information used in this project:
-------------------------------------------

1. Programming Language: [Android Kotlin][1].
2. Architecture: [Clean Architecture][2] based on [Android Jetpack][0].  For more resources on learning Android development, visit the [Developer Guides](https://developer.android.com/guide/) at [developer.android.com](https://developer.android.com).
3. Multiple Threads: [Kotlin Coroutine][14].
4. Third Party Libraries: [Retrofit][25], [Hilt][22], [Firebase][24], [MockK][21], [etc][15],...
5. Unit Test: [Android testing framework][3], [MockK][21], and [Robolectric][26]; Unit Test coverage Analysis using [JaCoCo][22].
6. [ScreenShots][16]

Moreover, you can read more detail about some project components by clicking to links contained at [References][17] part.

Libraries Used
--------------

* [Android Jetpack][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
  * [Test][3] - An Android testing framework for unit and runtime UI tests.
  * ....

* [Compose][4]
  * [Material][7] - Build Jetpack Compose UIs with ready to use Material Design Components.
  * [Foundation][8] - Write Jetpack Compose applications with ready to use building blocks and extend foundation to build your own design system pieces.
  * ....

* [Accompanist][5] - a group of libraries that aim to supplement Jetpack Compose with features that are commonly required by developers but not yet available.
  * [SwipeRefresh][9] - A library which provides a layout which provides the swipe-to-refresh UX pattern, similar to Android's SwipeRefreshLayout.
  * ....

* Third party
  * [Kotlin Coroutines][15] for managing background threads with simplified code and reducing needs for callbacks
  * [MockK][21] for unit test mocking. That provides DSL to mock behavior. Built from zero to fit Kotlin language.
    Supports named parameters, object mocks, coroutines and extension function mocking.
  * [JaCoCo][22] for Unit Test Coverage Analysis.
  * [Firebase][24] for Crashlytics, Analytics, Push Notification,....
  * [Retrofit][25] for Networking.
  * And a few other libraries ....

Plugin
--------------
* [Check-Dependency-Versions][10] - make easy to determine which dependencies have updates.

Code Analyze Tools
--------------
* [Ktlint][11] - A ktlint gradle plugin. Provides a convenient wrapper plugin over the ktlint project.
* [Spotless][12] - It’s pretty useful in automating fixes for pretty simple (and common) formatting mistakes as in spaces, newlines, removing unnecessary imports, etc.
* [Detekt][13] - Static code analysis for Kotlin.

[0]: https://developer.android.com/jetpack/components
[1]: https://kotlinlang.org/
[2]: http://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
[3]: https://en.wikipedia.org/wiki/Dependency_injection
[4]: https://developer.android.com/training/dependency-injection/hilt-android
[4]: https://developer.android.com/jetpack/compose
[5]: https://google.github.io/accompanist
[6]: https://developer.android.com/jetpack
[7]: https://developer.android.com/jetpack/androidx/releases/compose-material
[8]: https://developer.android.com/jetpack/androidx/releases/compose-foundation
[9]: https://google.github.io/accompanist/swiperefresh
[10]: https://github.com/ben-manes/gradle-versions-plugin
[11]: https://github.com/jlleitschuh/ktlint-gradle
[12]: https://github.com/diffplug/spotless
[13]: https://github.com/detekt/detekt
[14]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[15]: https://github.com/DanhDue/JetCleanArch#libraries-used
[16]: https://github.com/DanhDue/AndroidGenericAdapter#screenshots
[17]: https://github.com/DanhDue/AndroidGenericAdapter#references
[18]: https://viblo.asia/p/change-android-application-brightness-like-a-boss-djeZ1ok85Wz
[19]: https://viblo.asia/p/how-to-play-youtube-videos-in-an-android-webview-with-just-a-few-lines-of-code-RQqKL9mbZ7z
[20]: https://viblo.asia/p/setup-jacoco-for-android-project-gGJ59zB9KX2
[21]: https://mockk.io
[22]: https://www.jacoco.org/jacoco/trunk/index.html
[23]: https://insert-koin.io
[24]: https://firebase.google.com
[25]: https://square.github.io/retrofit
[26]: http://robolectric.org
[27]: https://viblo.asia/p/calbacks-trong-ung-dung-android-RnB5pk87lPG
[28]: https://viblo.asia/p/change-retrofits-base-url-at-runtime-ORNZqDLMK0n
[29]: https://viblo.asia/p/setup-jacoco-for-an-android-multiple-module-projectclean-architect-project-4dbZNNoqZYM

Screenshots
-----------
1. Coverage Overview.

![Coverage Overview](screenshots/unit_tests/coverage_overview.png "Coverage Overview.")

2. Unit Test Detail for a ViewModel.

![Unit Test Detail for ViewModel](screenshots/unit_tests/view_model_detail.png "Unit Test Detail for ViewModel.")

3. Unit Test Detail for a Repository

![Unit Test Detail for Repository](screenshots/unit_tests/repository_detail.png "Unit Test Detail for Repository.")

References
----------
* [setup Jacoco for an Android Multiple Module Project.][29]
* [Change Android Retrofit's Base Url at runtime.][28]
* [Change Android Brightness.][18]
* [Play Youtube videos on Androids.][19]
* [ Setup Jacoco for Android Project.][20]
* [Callbacks in Android Application.][27]

License
-------

Copyright 2023 DanhDue ExOICTIF, danhdue@gmail.com

Licensed to the Apache Software Foundation (ASF) under one or more contributor
license agreements.  See the NOTICE file distributed with this work for
additional information regarding copyright ownership.  The ASF licenses this
file to you under the Apache License, Version 2.0 (the "License"); you may not
use this file except in compliance with the License.  You may obtain a copy of
the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
License for the specific language governing permissions and limitations under
the License.
