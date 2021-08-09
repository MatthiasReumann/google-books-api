package googlebooksapi

import googlebooksapi.options.FilterOption
import googlebooksapi.options.PrintTypeOption
import googlebooksapi.options.ProjectionOption
import googlebooksapi.options.SortOption
import googlebooksapi.util.Parameters

class VolumeGetRequest {
    val parameters = Parameters()
    val query = VolumeQuery()

    fun search(text: String) = query.search(text)

    fun intitle(title: String) = query.intitle(title)

    fun inauthor(author: String) = query.inauthor(author)

    fun inpublisher(publisher: String) = query.inpublisher(publisher)

    fun subject(subject: String) = query.subject(subject)

    fun isbn(isbn: String) = query.isbn(isbn)

    fun lccn(lccn: String) = query.lccn(lccn)

    fun oclc(oclc: String) = query.oclc(oclc)

    fun download(format: String) = parameters.download(format)

    fun filter(option: FilterOption) = parameters.filter(option)

    fun langRestrict(language: String) = parameters.langRestrict(language)

    fun orderBy(option: SortOption) = parameters.orderBy(option)

    fun printType(type: PrintTypeOption) = parameters.printType(type)

    fun projection(projectionOption: ProjectionOption) = parameters.projection(projectionOption)

    fun startIndex(startIndex: Int) = parameters.startIndex(startIndex)

    fun maxResults(maxResults: Int) = parameters.maxResults(maxResults)
}