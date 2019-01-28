# KoDi
DI library, service locator that is like Koin with the following differences:
* you can use any object of any type for a qualifier(in Koin you can use strings only)
* you can create as much equal scopes as you want(in Koin you can create only one instance of a scope). This might be useful if your application can have two different screens hosed by one Fragment(say User Profile) in the backstack.
