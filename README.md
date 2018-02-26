# DiagonalDrawable
[ ![Download](https://api.bintray.com/packages/massivedisaster/drawable/diagonaldrawable/images/download.svg) ](https://bintray.com/massivedisaster/drawable/diagonaldrawable/_latestVersion)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

A Diagonal Drawable for backgrounds, etc.

<div align="center">
  <img src="art/sample.gif" />
</div>

### Download

Gradle:

```gradle
dependencies {
  implementation 'com.massivedisaster.drawable:diagonaldrawable:0.1.0'
}
```

### Usage

```java
DiagonalDrawable(ContextCompat.getColor(context, R.color.left),
                ContextCompat.getColor(context, R.color.right),
                DiagonalDrawable.Orientation.LEFT_RIGHT)
```

Available orientations:

```java
DiagonalDrawable.Orientation.LEFT_RIGHT
DiagonalDrawable.Orientation.RIGHT_LEFT
```

### License
[MIT LICENSE](LICENSE.md)
