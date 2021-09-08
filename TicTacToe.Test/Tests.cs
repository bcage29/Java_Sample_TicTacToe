using System;
using System.IO;
using System.Linq;
using NUnit.Framework;
using Xamarin.UITest;
using Xamarin.UITest.Queries;

namespace TicTacToe.Test
{
    [TestFixture(Platform.Android)]
  //  [TestFixture(Platform.iOS)]
    public class Tests
    {
        IApp app;
        Platform platform;

        public Tests(Platform platform)
        {
            this.platform = platform;
        }

        [SetUp]
        public void BeforeEachTest()
        {
            app = AppInitializer.StartApp(platform);
        }

        [Test]
        public void TicTacToeTest()
        {
            app.Repl();
            app.Tap(b => b.Marked("btn_0"));
            app.Tap(b => b.Marked("btn_1"));
            app.Tap(b => b.Marked("btn_2"));
            app.Tap(b => b.Marked("btn_3"));
            app.Tap(b => b.Marked("btn_4"));
            app.Tap(b => b.Marked("btn_5"));
;
            app.WaitForElement(c => c.Marked("resetGame"));

            Assert.IsTrue(true);
        }
    }
}
