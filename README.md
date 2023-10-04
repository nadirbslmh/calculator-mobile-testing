# calculator-mobile-testing

Mobile testing example using Appium and Serenity BDD.

## Notes
- The application that is used for testing is a [simple calculator application](https://drive.google.com/file/d/1gYumnP6d8hD2rkGDNL7e0Az7vm_ywH-R/view?usp=sharing).
- This example is tested in Android platform.
- This repository uses [Appium 2](https://appium.io/docs/en/2.0/quickstart/).

## How to Use

1. Clone this repository.
2. Configure the testing setup in `configuration.yaml` file that can be found in `src/src/main/resources` directory.
3. Make sure to provide the correct path for the application (apk) in `app` field inside `configuration.yaml` file.
4. Before run the test, start the appium server.

```shell
appium
```

5. Run the test with this command:

```shell
mvn clean verify
```