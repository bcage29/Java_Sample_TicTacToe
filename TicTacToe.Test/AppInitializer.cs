using System;
using Xamarin.UITest;
using Xamarin.UITest.Queries;

namespace TicTacToe.Test
{
    public class AppInitializer
    {
        public static IApp StartApp(Platform platform)
        {
            if (platform == Platform.Android)
            {
                return ConfigureApp.Android
                    .Debug()
                    .KeyStore("C:/Users/alfarahn/.android/debug.keystore", "android", "android", "androiddebugkey")
                    .InstalledApp("com.example.sampleapp")
                    .StartApp();
            }

            return ConfigureApp.iOS.StartApp();
        }
    }
}