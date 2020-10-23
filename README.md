Multi module donor app
=====================================================

Sample application for demonstrate flexible approach to design Android multi module project. 

It contains independent feature modules which you can easy reuse in another application.

Dagger2 is used for dependency injection.

Structure
--------------------------------
**app** - application module.

**list** - feature module responsible for the items list.

**detail** - feature module responsible for items detail.

**add** - feature module responsible for add new item.

**settings** - feature module responsible for settings screen.

**db** - independent core module providing database functionality.

How to reuse feature module
--------------------------------
Just add necessary module as gradle dependency to your project and configure this feature. For example, see [multimodule-superapp-example](https://github.com/AlexeyPanchenko/multimodule-superapp-example).