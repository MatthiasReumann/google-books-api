package googlebooksapi.exceptions

import io.ktor.http.*

class HelperRedirectException(code: HttpStatusCode, message: String) : HelperException(code, message) {}