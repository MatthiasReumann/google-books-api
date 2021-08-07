package googlebooksapi.exceptions

import io.ktor.http.*
import java.lang.Exception

open class HelperException(val code: HttpStatusCode, message: String) : Exception(message){}