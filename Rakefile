APP_PACKAGE    = 'org.opencoinage.android'
ANDROID_DEVICE = ENV['ANDROID_DEVICE'] || 'android-2.2'
ANDROID_SERIAL = ENV['ANDROID_SERIAL'] || 'emulator-5554'

desc "Launches the Android Virtual Device (AVD) emulator."
task :emulator do
  sh "emulator -avd #{ANDROID_DEVICE}"
end

desc "Builds a debug release of the application."
task :build do
  sh "ant debug"
end

file 'bin/OpenCoinage-debug.apk' do
  sh "ant debug"
end

desc "Installs the application onto the running Android emulator."
task :install => 'bin/OpenCoinage-debug.apk' do
  sh "adb -s #{ANDROID_SERIAL} install bin/*-debug.apk"
end

desc "Reinstalls the application onto the running Android emulator."
task :reinstall => 'bin/OpenCoinage-debug.apk' do
  sh "adb -s #{ANDROID_SERIAL} install -r bin/*-debug.apk"
end

desc "Uninstalls the application from the running Android emulator."
task :uninstall do
  sh "adb -s #{ANDROID_SERIAL} uninstall #{APP_PACKAGE}"
end

desc "Views the system log of the running Android emulator."
task :logcat do
  sh "adb -s #{ANDROID_SERIAL} logcat"
end

task :default => [:build, :reinstall]
