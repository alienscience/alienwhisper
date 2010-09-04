
//------- Utility functions for javascript tests -------------------------------

function assert(exp, message)
{
    if (!exp) throw message;
}

function assertEquals(a,b)
{
    if (a != b) throw a + " != " + b;
}

