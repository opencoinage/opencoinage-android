OpenCoinage for Android
=======================

<http://opencoinage.org/>

Dependencies
------------

### Platform

The application requires [Android 2.2][].

### Development

You are assumed to have installed the [Android SDK][] and properly
configured an Android 2.2-compatible Android Virtual Device (AVD) named
`android-2.2`.

Download
--------

To get a local working copy of the development repository, do:

    $ git clone git://github.com/opencoinage/opencoinage-android.git

Alternatively, download the latest development version as a tarball as
follows:

    $ wget http://github.com/opencoinage/opencoinage-android/tarball/master

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

To review the Android emulator's system log for any warnings, errors, or
exceptions, execute the following:

    $ rake logcat

Uninstallation
--------------

Should you wish to remove the application from your Android emulator, do:

    $ rake uninstall

Environment
-----------

The following are the default settings for environment variables that let
you customize which virtual or physical device the Rake tasks operate on:

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

[Android SDK]: http://developer.android.com/sdk/
[Android 2.2]: http://developer.android.com/sdk/android-2.2.html
