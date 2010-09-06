
//------- Utility functions for javascript tests -------------------------------

function assert(exp, message)
{
    if (!exp) throw message;
}

function assert_equals(a,b)
{
    if (a != b) throw a + " != " + b;
}


//------- Javascript tests -----------------------------------------------------

function test_assert()
{
    assert(1 == 1, "Assert 1 == 1");
    assert_equals(1,1);
}

function test_encrypt()
{
    var x = new sjcl.cipher.aes("woot");
    var c = new alienwhisper.crypt();
    var plaintext = "Hello world";
    var key = "testkey";
    var encrypted = c.encrypt(key, plaintext);
    assert_equals(plaintext, c.decrypt(key, encrypted));
}
