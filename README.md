OpenCoinage for Android
=======================

This is an [OpenCoinage.org][OpenCoinage] client application for the
[Android][] open mobile platform.

_Note: this is at present pre-alpha software, and is unlikely to be of much
interest to you. Check back later!_

Dependencies
------------

### Platform

The application requires and runs on the [Android 2.2][] platform. Older
versions of the Android platform may potentially work, but are not
supported.

### Development

In order to build and run the development version of the application, you
will need to have installed the [Android SDK][] and properly configured an
Android 2.2-compatible Android Virtual Device (AVD) named `android-2.2`.

The Android SDK is available for the Mac OS X, Linux, and Windows operating
systems. In addition to the SDK, the application's build system requires the
[Rake][] build program that typically comes bundled with the [Ruby][]
language runtime. If you are on Mac OS X or Linux, you almost certainly
already have Rake available; on Windows, you can obtain it from the
[RubyInstaller for Windows](http://rubyinstaller.org/) bundle.

Download
--------

To get a local working copy of the development repository, do:

    $ git clone git://github.com/opencoinage/opencoinage-android.git

Alternatively, download the latest development version as a tarball as
follows:

    $ wget http://github.com/opencoinage/opencoinage-android/tarball/master

Configuration
-------------

Before you can build the application, you'll have to tell the build system
the file system path to the Android SDK. This is done by creating a
`local.properties` file in your working directory, as follows:

    $ echo 'sdk.dir=/opt/android' > local.properties

Replace the shown `/opt/android` path with the base directory where you
installed the Android SDK on your system.

Installation
------------

To build and install the very latest bleeding-edge development version of
the application onto a running Android emulator, do:

    $ rake build && rake install

To reinstall or upgrade the application when it has already been previously
installed onto the emulator, do:

    $ rake build && rake reinstall

Debugging
---------

To review the Android emulator's system log for any potentially relevant
warnings, errors, or exceptions, do:

    $ rake logcat

Uninstallation
--------------

Should you wish to remove the application from your Android emulator, do:

    $ rake uninstall

Environment
-----------

The following are the default settings for environment variables that let
you customize which virtual or physical device the aforementioned Rake tasks
operate on:

    $ export ANDROID_DEVICE='android-2.2'
    $ export ANDROID_SERIAL='emulator-5554'

Mailing List
------------

<http://groups.google.com/group/opencoinage>

Author
------

[Arto Bendiken](mailto:arto.bendiken@gmail.com) - <http://ar.to/>

Contributors
------------

Refer to the accompanying `CREDITS` file.

License
-------

This is free and unencumbered public domain software. For more information,
see <http://unlicense.org/> or the accompanying `UNLICENSE` file.

[OpenCoinage]: http://opencoinage.org/
[Ruby]:        http://ruby-lang.org/
[Rake]:        http://rake.rubyforge.org/
[Android]:     http://en.wikipedia.org/wiki/Android_(operating_system)
[Android SDK]: http://developer.android.com/sdk/
[Android 2.2]: http://developer.android.com/sdk/android-2.2.html
