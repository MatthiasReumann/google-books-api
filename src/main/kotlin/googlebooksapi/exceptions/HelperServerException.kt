package googlebooksapi.exceptions

import io.ktor.http.*

class HelperServerException(code: HttpStatusCode, message: String) : HelperException(code, message) {}