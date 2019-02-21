# Build it bigger
In this project, I created an app with multiple flavors that uses multiple libraries and Google
Cloud Endpoints. The finished app will consist of four modules. A Java library that provides jokes, 
a Google Cloud Endpoints (GCE) project that serves those jokes, an Android Library containing an 
activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes 
them to the Android Library for display.

# Resources
- GCE Backend is completed thanks to Google's example found on [github](https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend)
- Android Async test resource [StackOverflow](https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework) 