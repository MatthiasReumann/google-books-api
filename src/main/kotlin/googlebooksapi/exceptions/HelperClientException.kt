package googlebooksapi.exceptions

import io.ktor.http.*

class HelperClientException(code: HttpStatusCode, message: String) : HelperException(code, message) {}