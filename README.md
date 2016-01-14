# BreadcrumbView

This is and Android view intended to show a breadcrumb of a given path

![Screenshot](https://raw.githubusercontent.com/worldline-spain/breadcrumbview/master/art/screenshot.png "Example")


## Installing

Just add the following to your build.gradle file

```groovy
  compile 'com.worldline:breadcrumbview:1.0.0'
```

## Usage
First, add a namespace into your layout for the non-system resources, for example:

```xml
    xmlns:app="http://schemas.android.com/apk/res-auto"
```

Insert the view on your layout. Here an example:

```xml
    <com.worldline.breadcrumbview.BreadcrumbView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:maxLevels="4"
        app:separator="\\."
        app:path="Apples.Strawberries.Bananas"
        app:labelColor="@color/colorAccent"
        app:labelTextSize="16sp"
        app:labelTextColor="#000"
        app:endType="Closed"
        app:startType="Open"
        />
```

### Properties

* **maxLevels**: the number of levels that the view should fit. If the path has less levels, the extra ones won't be shown. If it has more, they will be ignored
* **path**: the path string that will be splitted into crumbs
* **separator**: the regex expression used to split the path
* **labelTextSize**: size of the text to be shown in the crumbs
* **labelTextColor**: color of the text to be shown in the crumbs
* **labelColor**: the color of the crumbs themselves
* **startType**: values *Closed* (square) or *Open* (arrow) will determine how the first crumb left part will be drawn
* **endType**: values *Closed* (square) or *Open* (arrow) will determine how the last crumb right part will be drawn

### Events

You can subscribe to the event ```onPathLabelClick``` to the method ```setOnPathLabelClickListener```. This method receives a single argument with the index of the tapped crumb (starting in 0).

## LICENSE ##

    Copyright 2016 Wordline Spain

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
