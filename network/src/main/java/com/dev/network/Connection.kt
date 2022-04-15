package com.dev.network

private const val DEFAULT_TIMEOUT = 10L

internal abstract class Connection {
    companion object {
        const val TIMEOUT: Long = DEFAULT_TIMEOUT
    }

    object Read {
        const val TIMEOUT: Long = DEFAULT_TIMEOUT
    }

    object Write {
        const val TIMEOUT: Long = DEFAULT_TIMEOUT
    }
}
