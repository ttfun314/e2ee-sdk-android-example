package com.example.myapplicationusingnewlib

import android.util.Log
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.x.e2ee.CryptoSDK;
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EncryptorTest {

    @Test
    fun testEncrypt() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val cryptoSDK = CryptoSDK(context)
        cryptoSDK.init()
        val message = "Hello, Android!"
        val encryptedMessage = cryptoSDK.encrypt(message, cryptoSDK.publicKey)

        // Assert that the encrypted message is not null and not equal to the original message
        assertNotNull(encryptedMessage)
        assertNotEquals(message, encryptedMessage)

        Log.d("EncryptorTest", "Encrypted message: $encryptedMessage")

        val decryptedMessage = cryptoSDK.decrypt(encryptedMessage)
        Log.d("EncryptorTest", "Decrypted message: $decryptedMessage")
        assertEquals(message, decryptedMessage)
    }

}
